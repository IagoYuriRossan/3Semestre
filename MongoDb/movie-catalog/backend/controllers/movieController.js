import Movie from '../models/movie.js';
import * as tmdbService from '../services/tmdbService.js';

// Search movies and save to MongoDB
export const searchMovies = async (req, res) => {
  try {
    const { query, genre, year } = req.query;
    let movies = [];

    if (query) {
      movies = await tmdbService.searchMovies(query);
    } else if (genre) {
      movies = await tmdbService.getMoviesByGenre(genre);
    } else if (year) {
      movies = await tmdbService.getMoviesByYear(year);
    } else {
      return res.status(400).json({ message: 'Please provide a search query, genre, or year' });
    }

    // Process and save movies to MongoDB
    const processedMovies = await Promise.all(
      movies.map(async (movie) => {
        // Check if movie already exists in DB
        let existingMovie = await Movie.findOne({ tmdbId: movie.id });
        
        if (!existingMovie) {
          // Get detailed movie info
          const movieDetails = await tmdbService.getMovieDetails(movie.id);
          
          // Extract trailer URL if available
          let trailerUrl = '';
          if (movieDetails.videos && movieDetails.videos.results.length > 0) {
            const trailer = movieDetails.videos.results.find(video => video.type === 'Trailer');
            if (trailer) {
              trailerUrl = `https://www.youtube.com/watch?v=${trailer.key}`;
            }
          }
          
          // Extract genres
          const genres = movieDetails.genres.map(genre => genre.name);
          
          // Create new movie in DB
          existingMovie = await Movie.create({
            tmdbId: movie.id,
            title: movie.title,
            description: movie.overview,
            releaseDate: new Date(movie.release_date),
            genres: genres,
            rating: movie.vote_average,
            posterPath: movie.poster_path,
            trailerUrl: trailerUrl
          });
        }
        
        return existingMovie;
      })
    );

    res.json(processedMovies);
  } catch (error) {
    console.error('Error in searchMovies controller:', error);
    res.status(500).json({ message: 'Server error', error: error.message });
  }
};

// Get all movies from MongoDB
export const getMovies = async (req, res) => {
  try {
    const { sort } = req.query;
    let sortOption = {};
    
    if (sort === 'title') {
      sortOption = { title: 1 };
    } else if (sort === 'releaseDate') {
      sortOption = { releaseDate: -1 };
    } else {
      sortOption = { createdAt: -1 };
    }
    
    const movies = await Movie.find().sort(sortOption);
    res.json(movies);
  } catch (error) {
    console.error('Error in getMovies controller:', error);
    res.status(500).json({ message: 'Server error', error: error.message });
  }
};

// Get movie by ID
export const getMovieById = async (req, res) => {
  try {
    const movie = await Movie.findById(req.params.id);
    
    if (!movie) {
      return res.status(404).json({ message: 'Movie not found' });
    }
    
    res.json(movie);
  } catch (error) {
    console.error('Error in getMovieById controller:', error);
    res.status(500).json({ message: 'Server error', error: error.message });
  }
};

// Get all genres
export const getGenres = async (req, res) => {
  try {
    const genres = await tmdbService.getGenres();
    res.json(genres);
  } catch (error) {
    console.error('Error in getGenres controller:', error);
    res.status(500).json({ message: 'Server error', error: error.message });
  }
};