FROM mhart/alpine-node:16



ENV PORT=5000 
ENV NODE_ENV=development
ENV MONGO_URI=mongodb+srv://omarkarboul:HcwMU0wflgPC7obJ@scaleitcluster.uac7x.mongodb.net/Scale-IT-NaN?retryWrites=true&w=majority



EXPOSE 5000

COPY package.json .
RUN npm install
COPY . .
CMD npm run dev
