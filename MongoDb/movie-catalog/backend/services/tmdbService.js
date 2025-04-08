import axios from 'axios';
import dotenv from 'dotenv';

dotenv.config();

const TMDB_API_KEY = process.env.TMDB_API_KEY;
const BASE_URL = 'https://api.themoviedb.org/3';

// Search movies by query
export const searchMovies = async (query) => {
  try {
    const response = await axios.get(`${BASE_URL}/search/movie`, {
      params: {
        api_key: TMDB_API_KEY,
        query: query,
        language: 'pt-BR'
      }
    });
    return response.data.results;
  } catch (error) {
    console.error('Error searching movies:', error);
    throw error;
  }
};

// Get movie details by ID
export const getMovieDetails = async (movieId) => {
  try {
    const response = await axios.get(`${BASE_URL}/movie/${movieId}`, {
      params: {
        api_key: TMDB_API_KEY,
        language: 'pt-BR',
        append_to_response: 'videos'
      }
    });
    return response.data;
  } catch (error) {
    console.error('Error getting movie details:', error);
    throw error;
  }
};

// Get movies by genre
export const getMoviesByGenre = async (genreId) => {
  try {
    const response = await axios.get(`${BASE_URL}/discover/movie`, {
      params: {
        api_key: TMDB_API_KEY,
        with_genres: genreId,
        language: 'pt-BR'
      }
    });
    return response.data.results;
  } catch (error) {
    console.error('Error getting movies by genre:', error);
    throw error;
  }
};

// Get movies by year
export const getMoviesByYear = async (year) => {
  try {
    const response = await axios.get(`${BASE_URL}/discover/movie`, {
      params: {
        api_key: TMDB_API_KEY,
        primary_release_year: year,
        language: 'pt-BR'
      }
    });
    return response.data.results;
  } catch (error) {
    console.error('Error getting movies by year:', error);
    throw error;
  }
};

// Get all genres
export const getGenres = async () => {
  try {
    const response = await axios.get(`${BASE_URL}/genre/movie/list`, {
      params: {
        api_key: TMDB_API_KEY,
        language: 'pt-BR'
      }
    });
    return response.data.genres;
  } catch (error) {
    console.error('Error getting genres:', error);
    throw error;
  }
};