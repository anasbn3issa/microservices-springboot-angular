import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SterilizationService {
  readonly API_URL = 'http://localhost:8888/sterilizations';

  constructor(private httpClient: HttpClient) { }

  getAllSterilizations() {
    return this.httpClient.get(`${this.API_URL}`);
  }

  editSterilization(sterilization: any, id: any) {    
    return this.httpClient.put(`${this.API_URL}/${id}`, sterilization);
  }

  addSterilization(sterilization: any) {
    return this.httpClient.post(`${this.API_URL}`, sterilization);
  }

  deleteSterilization(id: any) {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }
}
