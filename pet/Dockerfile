FROM node:16

RUN apt-get update && apt-get install -y bzip2 libfontconfig && apt-get autoremove -y && rm -rf /etc/apt/sources.list.d

ENV PORT=5000 
ENV NODE_ENV=development
ENV MONGO_URI=mongodb+srv://omarkarboul:HcwMU0wflgPC7obJ@scaleitcluster.uac7x.mongodb.net/Scale-IT-NaN?retryWrites=true&w=majority

COPY package.json .

RUN npm i && nodemon index.js

EXPOSE 5000
