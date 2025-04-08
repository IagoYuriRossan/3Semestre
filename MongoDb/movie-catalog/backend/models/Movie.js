import mongoose from 'mongoose';

const movieSchema = new mongoose.Schema({
  tmdbId: {
    type: Number,
    required: true,
    unique: true
  },
  title: {
    type: String,
    required: true
  },
  description: {
    type: String,
    required: true
  },
  releaseDate: {
    type: Date,
    required: true
  },
  genres: [{
    type: String,
    required: true
  }],
  rating: {
    type: Number,
    required: true
  },
  posterPath: {
    type: String
  },
  trailerUrl: {
    type: String
  },
  createdAt: {
    type: Date,
    default: Date.now
  }
});

// Create index for search functionality
movieSchema.index({ title: 'text', genres: 'text' });

const Movie = mongoose.model('Movie', movieSchema);

export default Movie;