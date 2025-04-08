import express from 'express';
import * as movieController from '../controllers/MovieController.js';

const router = express.Router();

// Search movies route
router.get('/search', movieController.searchMovies);

// Get all movies route
router.get('/', movieController.getMovies);

// Get movie by ID route
router.get('/:id', movieController.getMovieById);

// Get all genres route
router.get('/genres/all', movieController.getGenres);

export default router;