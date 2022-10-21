const express = require("express");
const dotenv = require("dotenv");
var path = require("path");
const colors = require("colors");


const connectDB = require("./src/db/db");


const port = process.env.PORT || 5000;
dotenv.config();
connectDB();

const app = express();



app.use(express.json());
app.use(express.urlencoded({ extended: false }));


app.use("/api/pets", require("./src/routes/pet"));


app.listen(port, () => console.log(`Server started on port ${port}`));
