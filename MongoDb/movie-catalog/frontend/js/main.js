// DOM elements
const moviesContainer = document.getElementById('movies-container');
const searchForm = document.getElementById('search-form');
const searchInput = document.getElementById('search-input');
const searchTypeSelect = document.getElementById('search-type');
const genreSelect = document.getElementById('genre-select');
const yearInput = document.getElementById('year-input');
const sortSelect = document.getElementById('sort-select');
const loadingSpinner = document.getElementById('loading-spinner');
const noResults = document.getElementById('no-results');
const modal = document.getElementById('movie-modal');
const modalContent = document.getElementById('modal-content');
const closeButton = document.querySelector('.close-button');

// Mock API functions (replace with your actual API calls)
async function fetchMovies(sortBy = '') {
    // Simulate fetching movies from an API
    await new Promise(resolve => setTimeout(resolve, 500)); // Simulate network delay
    let movies = [
        { _id: '1', title: 'Movie 1', posterPath: '/poster1.jpg', releaseDate: '2023-01-01', rating: 7.5, description: 'Description 1', genres: ['Action', 'Sci-Fi'], trailerUrl: 'https://www.youtube.com/watch?v=trailer1' },
        { _id: '2', title: 'Movie 2', posterPath: '/poster2.jpg', releaseDate: '2023-02-15', rating: 8.0, description: 'Description 2', genres: ['Comedy', 'Romance'], trailerUrl: 'https://www.youtube.com/watch?v=trailer2' },
        { _id: '3', title: 'Movie 3', posterPath: '/poster3.jpg', releaseDate: '2023-03-20', rating: 6.8, description: 'Description 3', genres: ['Drama', 'Thriller'], trailerUrl: 'https://www.youtube.com/watch?v=trailer3' }
    ];

    if (sortBy === 'rating') {
        movies.sort((a, b) => b.rating - a.rating);
    }

    return movies;
}

async function fetchGenres() {
    // Simulate fetching genres from an API
    await new Promise(resolve => setTimeout(resolve, 300)); // Simulate network delay
    return [
        { id: 'action', name: 'Ação' },
        { id: 'comedy', name: 'Comédia' },
        { id: 'drama', name: 'Drama' },
        { id: 'sci-fi', name: 'Ficção Científica' }
    ];
}

async function searchMovies(searchType, searchValue) {
    // Simulate searching movies based on search type and value
    await new Promise(resolve => setTimeout(resolve, 400)); // Simulate network delay
    let movies = await fetchMovies(); // Fetch all movies first

    if (searchType === 'query') {
        movies = movies.filter(movie => movie.title.toLowerCase().includes(searchValue.toLowerCase()));
    } else if (searchType === 'genre') {
        movies = movies.filter(movie => movie.genres.includes(searchValue));
    } else if (searchType === 'year') {
        movies = movies.filter(movie => new Date(movie.releaseDate).getFullYear() === parseInt(searchValue));
    }

    return movies;
}

function getImageUrl(posterPath) {
    // Simulate constructing image URL
    return `https://example.com/images${posterPath}`;
}

async function fetchMovieById(id) {
    // Simulate fetching a movie by ID
    await new Promise(resolve => setTimeout(resolve, 200)); // Simulate network delay
    const movies = await fetchMovies();
    return movies.find(movie => movie._id === id);
}

// Event listeners
document.addEventListener('DOMContentLoaded', init);
searchForm.addEventListener('submit', handleSearch);
searchTypeSelect.addEventListener('change', toggleSearchFields);
sortSelect.addEventListener('change', handleSort);
closeButton.addEventListener('click', closeModal);
window.addEventListener('click', (e) => {
    if (e.target === modal) {
        closeModal();
    }
});

// Initialize the app
async function init() {
    try {
        showLoading();
        
        // Load genres for the dropdown
        await loadGenres();
        
        // Load initial movies
        const movies = await fetchMovies();
        renderMovies(movies);
        
        hideLoading();
    } catch (error) {
        console.error('Initialization error:', error);
        hideLoading();
        showError('Erro ao carregar os filmes. Por favor, tente novamente mais tarde.');
    }
}

// Load genres into the dropdown
async function loadGenres() {
    try {
        const genres = await fetchGenres();
        
        genreSelect.innerHTML = '<option value="">Selecione um gênero</option>';
        
        genres.forEach(genre => {
            const option = document.createElement('option');
            option.value = genre.id;
            option.textContent = genre.name;
            genreSelect.appendChild(option);
        });
    } catch (error) {
        console.error('Error loading genres:', error);
    }
}

// Toggle search fields based on search type
function toggleSearchFields() {
    const searchType = searchTypeSelect.value;
    
    // Hide all fields first
    searchInput.classList.add('hidden');
    genreSelect.classList.add('hidden');
    yearInput.classList.add('hidden');
    
    // Show the appropriate field based on search type
    if (searchType === 'query') {
        searchInput.classList.remove('hidden');
    } else if (searchType === 'genre') {
        genreSelect.classList.remove('hidden');
    } else if (searchType === 'year') {
        yearInput.classList.remove('hidden');
    }
}

// Handle search form submission
async function handleSearch(e) {
    e.preventDefault();
    
    const searchType = searchTypeSelect.value;
    let searchValue = '';
    
    if (searchType === 'query') {
        searchValue = searchInput.value.trim();
        if (!searchValue) {
            alert('Por favor, digite um termo de busca.');
            return;
        }
    } else if (searchType === 'genre') {
        searchValue = genreSelect.value;
        if (!searchValue) {
            alert('Por favor, selecione um gênero.');
            return;
        }
    } else if (searchType === 'year') {
        searchValue = yearInput.value.trim();
        if (!searchValue) {
            alert('Por favor, digite um ano.');
            return;
        }
    }
    
    try {
        showLoading();
        
        const movies = await searchMovies(searchType, searchValue);
        renderMovies(movies);
        
        hideLoading();
    } catch (error) {
        console.error('Search error:', error);
        hideLoading();
        showError('Erro ao buscar filmes. Por favor, tente novamente mais tarde.');
    }
}

// Handle sort change
async function handleSort() {
    try {
        showLoading();
        
        const sortBy = sortSelect.value;
        const movies = await fetchMovies(sortBy === 'default' ? '' : sortBy);
        renderMovies(movies);
        
        hideLoading();
    } catch (error) {
        console.error('Sort error:', error);
        hideLoading();
        showError('Erro ao ordenar filmes. Por favor, tente novamente mais tarde.');
    }
}

// Render movies to the DOM
function renderMovies(movies) {
    moviesContainer.innerHTML = '';
    
    if (movies.length === 0) {
        noResults.classList.remove('hidden');
        return;
    }
    
    noResults.classList.add('hidden');
    
    movies.forEach(movie => {
        const movieCard = document.createElement('div');
        movieCard.className = 'movie-card';
        movieCard.dataset.id = movie._id;
        
        const releaseDate = new Date(movie.releaseDate).toLocaleDateString('pt-BR');
        
        movieCard.innerHTML = `
            <img src="${getImageUrl(movie.posterPath)}" alt="${movie.title}" class="movie-poster">
            <div class="movie-info">
                <h3 class="movie-title">${movie.title}</h3>
                <p class="movie-release-date">${releaseDate}</p>
                <div class="movie-rating">
                    <i class="fas fa-star"></i>
                    <span>${movie.rating.toFixed(1)}</span>
                </div>
            </div>
        `;
        
        movieCard.addEventListener('click', () => openMovieDetails(movie._id));
        
        moviesContainer.appendChild(movieCard);
    });
}

// Open movie details modal
async function openMovieDetails(id) {
    try {
        showLoading();
        
        const movie = await fetchMovieById(id);
        
        const releaseDate = new Date(movie.releaseDate).toLocaleDateString('pt-BR');
        
        modalContent.innerHTML = `
            <div class="movie-detail">
                <img src="${getImageUrl(movie.posterPath)}" alt="${movie.title}" class="movie-detail-poster">
                <div class="movie-detail-info">
                    <h2 class="movie-detail-title">${movie.title}</h2>
                    <div class="movie-detail-meta">
                        <span><i class="far fa-calendar-alt"></i> ${releaseDate}</span>
                        <span><i class="fas fa-star"></i> ${movie.rating.toFixed(1)}</span>
                    </div>
                    <p class="movie-detail-description">${movie.description}</p>
                    <div class="movie-detail-genres">
                        ${movie.genres.map(genre => `<span class="genre-tag">${genre}</span>`).join('')}
                    </div>
                    ${movie.trailerUrl ? `
                        <div class="movie-detail-trailer">
                            <a href="${movie.trailerUrl}" target="_blank" class="trailer-button">
                                <i class="fab fa-youtube"></i> Assistir Trailer
                            </a>
                        </div>
                    ` : ''}
                </div>
            </div>
        `;
        
        modal.style.display = 'block';
        
        hideLoading();
    } catch (error) {
        console.error('Error opening movie details:', error);
        hideLoading();
        showError('Erro ao carregar detalhes do filme. Por favor, tente novamente mais tarde.');
    }
}

// Close modal
function closeModal() {
    modal.style.display = 'none';
}

// Show loading spinner
function showLoading() {
    loadingSpinner.classList.remove('hidden');
}

// Hide loading spinner
function hideLoading() {
    loadingSpinner.classList.add('hidden');
}

// Show error message
function showError(message) {
    alert(message);
}