import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PetService {
    readonly API_URL = 'http://localhost:5000/pets';


  constructor(private httpClient: HttpClient) { }

  getAllPets() {
    return this.httpClient.get(`${this.API_URL}`);
  }
}
