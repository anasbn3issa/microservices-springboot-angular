import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OperateurService {
  readonly API_URL = 'http://localhost:8888/login';

  constructor(private httpClient: HttpClient) {}

  login() {
    return this.httpClient.post(`${this.API_URL}/`, {
      name: 'root',
      password: 'root',
    });
  }

  getAllOperateurs() {
    return this.httpClient.get(`${this.API_URL}/`);
  }
  addOperateur(operateur: any) {
    return this.httpClient.post(`${this.API_URL}/add-operateur`, operateur);
  }
  editOperateur(operateur: any) {
    return this.httpClient.put(`${this.API_URL}/modify-operateur`, operateur);
  }
  deleteOperateur(idOperateur: any) {
    return this.httpClient.delete(
      `${this.API_URL}/remove-operateur/${idOperateur}`
    );
  }
}
