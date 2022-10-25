import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class VaccineService {
  readonly API_URL = 'http://localhost:8888/vaccines';
  constructor(private httpClient: HttpClient) {}

  getAllVaccines() {
    return this.httpClient.get(`${this.API_URL}`);
  }
  addVaccine(vaccine: any) {
    return this.httpClient.post(`${this.API_URL}`, vaccine);
  }
  deleteVaccine(id: any) {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }
  editVaccine(vaccine: any, id: any) {
    return this.httpClient.put(`${this.API_URL}/${id}`, vaccine);
  }
}
