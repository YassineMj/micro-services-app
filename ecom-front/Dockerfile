# Stage 1: Compile and Build angular codebase
FROM node:20-alpine as build

WORKDIR /usr/local/app

# Copier uniquement package.json et package-lock.json
COPY package*.json ./

# Installer les dépendances dans le conteneur (Linux)
RUN npm ci

# Copier le reste du code
COPY ./ ./

# Générer le build Angular
RUN npm run build

# Stage 2: Serve app with nginx
FROM nginx:alpine
COPY --from=build /usr/local/app/dist/ecom-front/browser /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
