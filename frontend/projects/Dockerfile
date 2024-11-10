FROM node:18-alpine AS build

WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

EXPOSE 4200

CMD ["npm", "start"]


# Stage 2: Serve the built app with Nginx
#FROM nginx:alpine
#
#EXPOSE 80
#COPY --from=build /app/dist/frontend /usr/share/nginx/html
##COPY nginx.conf /etc/nginx/nginx.conf
#
#CMD ["nginx", "-g", "daemon off;"]
