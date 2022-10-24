FROM node:16

WORKDIR /usr/local/app
COPY ./ /usr/local/app/


COPY package.json .


RUN npm install -g @angular/cli
RUN npm install
RUN npm run build


# Stage 2: Serve app with nginx server

FROM nginx:1.19.6-alpine

COPY --from=build /usr/local/app/dist/crudtuto-Front /usr/share/nginx/html
EXPOSE 80
