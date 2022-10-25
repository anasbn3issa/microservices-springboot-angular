# ms-wiggler-undefined

<div id="top"></div>

This is an academic project developed by <strong>undefined team</strong> @Esprit University Tunisia.
In this repository we are using microservices using spring & nodejs to build a web application that allows users to create and share their own pets .

We used spring security for the authetification and authorization of the users and we used JWT for the authetification and authorization of the microservices.
## Getting Started

1. Build, (re)create, start, and attache to containers for a service. 
```sh
  docker compose up
  ```
2. Install front dependecies 
```sh
  cd angular-front && yarn install
  ```
4. And run the front server
  ```sh
  yarn run start
  ```

## DOCUMENTATION

Every micro service is using its own port in the local but using our <strong>gatway</strong> we can access all the microservices using the same port 8888.

### Frontend
Angular application in which we can communicate with the backend using the gateway.


### Micro-Services

1. PET-SERVICE (Nodejs)
  - GET /pets
  - GET /pets/:id
  - POST /pets
  - PUT /pets/:id
  - DELETE /pets/:id
2. ASSOCIATION-SERVICE (Spring)
  - GET /associations
  - GET /associations/:id
  - POST /associations
  - PUT /associations/:id
  - DELETE /associations/:id
3. LOCAL-SERVICE (Spring)
  - GET /locals
  - GET /locals/:id
  - POST /locals
  - PUT /locals/:id
  - DELETE /locals/:id
4. REWARD-SERVICE (Spring)
  - GET /rewards
  - POST /rewards
  - PUT /rewards/:id
  - DELETE /rewards/:id
5. STERILIZATION-SERVICE (Spring)
  - GET /sterilizations
  - GET /sterilizations/:id
  - POST /sterilizations
  - PUT /sterilizations/:id
  - DELETE /sterilizations/:id
6. VETERINARIAN-SERVICE (Spring)
  - GET /veterinarians
  - GET /veterinarians/:id
  - POST /veterinarians
  - PUT /veterinarians/:id
  - DELETE /veterinarians/:id
7. VACCINATION-SERVICE (Spring)
  - GET /vaccines
  - GET /vaccines/:id
  - POST /vaccines
  - PUT /vaccines/:id
  - DELETE /vaccines/:id
  - GET /vaccines/count/:idTypeVaccine
  - GET /vaccineTypes
  - GET /vaccineTypes/:id
  - POST /vaccineTypes
  - PUT /vaccineTypes/:id
  - DELETE /vaccineTypes/:id

### Database
1. MongoDB
2. MySQL
3. Redis
4. Postgres

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- ACKNOWLEDGMENTS -->
## Acknowledgments

This project was developed under the supervision of Mme Ines Elmejid . 

<p align="right">(<a href="#top">back to top</a>)</p>
