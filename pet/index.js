const express = require("express");
const dotenv = require("dotenv");
var path = require("path");
const colors = require("colors");
const Eureka = require("eureka-js-client").Eureka;

const connectDB = require("./src/db/db");

const port = process.env.PORT || 5000;
dotenv.config();
connectDB();

const app = express();

const client = new Eureka({
  // application instance information
  instance: {
    app: "pet",
    instanceId: "petMS",
    hostName: "pet",
    ipAddr: process.env.pet,
    statusPageUrl: process.env.hostname,
    healthCheckUrl: process.env.health,
    port: {
      $: 5000,
      "@enabled": "true",
    },
    vipAddress: "pets",
    dataCenterInfo: {
      "@class": "com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo",
      name: "MyOwn",
    },
    registerWithEureka: true,
    fetchRegistry: true,
    preferIpAddress: true,
  },
  eureka: {
    // eureka server host / port
    host: "localhost",
    port: 8761,
    servicePath: "/eureka/apps",
  },
});

client.logger.level("debug");
client.start((error) => {
  console.log(error || "complete");
});
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use("/pets", require("./src/routes/pet"));

app.listen(port, () => console.log(`Server started on port ${port}`));
