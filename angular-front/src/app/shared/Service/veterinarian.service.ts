import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VeterinarianService {

      readonly API_URL = 'http://localhost:8888/veterinarians';


  constructor(private httpClient: HttpClient) { }

  getAllVeterinarians() {
    return this.httpClient.get(`${this.API_URL}`);
  }

  editVeterinarian(sterilization: any, id: any) {    
    return this.httpClient.put(`${this.API_URL}/${id}`, sterilization);
  }

  addVeterinarian(sterilization: any) {
    return this.httpClient.post(`${this.API_URL}`, sterilization);
  }

  deleteVeterinarian(id: any) {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }
}
