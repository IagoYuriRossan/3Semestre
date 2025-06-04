import swaggerJSDoc from 'swagger-jsdoc';
 import swaggerUi from 'swagger-ui-express';
 import { Express } from 'express';
 const options = {
 definition: {
    openapi: '3.0.0',
    info: { title: 'Fatec Orders', version: '1.0.0' },
    components: {
    securitySchemes: {
    TokenAuth: {
    type: 'http',
    scheme: 'bearer',
    bearerFormat: 'JWT',
 }
 }
 },
 security: [{ TokenAuth: [] }]
 },
 apis: ['./src/routes/*.ts', './src/swagger/schemas.ts'],
 };
 export function setupSwagger(app: Express) {
    const swaggerSpec = swaggerJSDoc(options);
 app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerSpec));
 }