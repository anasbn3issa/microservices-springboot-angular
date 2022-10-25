import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LocalService {
  // readonly API_URL = 'http://localhost:8094/locals';
  readonly API_URL = 'http://localhost:8888/locals';
  constructor(private httpClient: HttpClient) {}

  getAllLocals() {
    return this.httpClient.get(`${this.API_URL}`);
  }
  addLocal(local: any) {
    return this.httpClient.post(`${this.API_URL}`, local);
  }
  deleteLocal(id: any) {
    return this.httpClient.delete(`${this.API_URL}/${id}`);
  }
  editLocal(local: any, id: any) {
    return this.httpClient.put(`${this.API_URL}/${id}`, local);
  }
}
