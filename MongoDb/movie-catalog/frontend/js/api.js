// API service for frontend
const API_URL = 'http://localhost:3000/api';
const TMDB_IMAGE_BASE_URL = 'https://image.tmdb.org/t/p/w500';

// Fetch all movies from the database
async function fetchMovies(sortBy = '') {
    try {
        const url = sortBy ? `${API_URL}/movies?sort=${sortBy}` : `${API_URL}/movies`;
        const response = await fetch(url);
        
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Error fetching movies:', error);
        throw error;
    }
}

// Search movies by query, genre, or year
async function searchMovies(searchType, searchValue) {
    try {
        let url = `${API_URL}/movies/search?`;
        
        if (searchType === 'query') {
            url += `query=${encodeURIComponent(searchValue)}`;
        } else if (searchType === 'genre') {
            url += `genre=${searchValue}`;
        } else if (searchType === 'year') {
            url += `year=${searchValue}`;
        }
        
        const response = await fetch(url);
        
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Error searching movies:', error);
        throw error;
    }
}

// Fetch movie details by ID
async function fetchMovieById(id) {
    try {
        const response = await fetch(`${API_URL}/movies/${id}`);
        
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Error fetching movie details:', error);
        throw error;
    }
}

// Fetch all genres
async function fetchGenres() {
    try {
        const response = await fetch(`${API_URL}/movies/genres/all`);
        
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        
        return await response.json();
    } catch (error) {
        console.error('Error fetching genres:', error);
        throw error;
    }
}

// Get full image URL
function getImageUrl(posterPath) {
    if (!posterPath) {
        return 'https://via.placeholder.com/500x750?text=No+Image+Available';
    }
    return `${TMDB_IMAGE_BASE_URL}${posterPath}`;
}