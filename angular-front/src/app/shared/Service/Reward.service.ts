import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class RewardService {
  // readonly FIX_CORS = 'https://infinite-bastion-91954.herokuapp.com/';
  readonly API_URL = 'http://localhost:8085/rewards';
  constructor(private httpClient: HttpClient) {}

  // fix cors problem
  // https://stackoverflow.com/questions/43871637/no-access-control-allow-origin-header-is-present-on-the-requested-resource-whe
  getAllRewards() {
    return this.httpClient.get(`${this.API_URL}/all`);
  }

  addReward(reward: any) {
    return this.httpClient.post(`${this.API_URL}/add`, reward);
  }

  deleteReward(id: any) {
    return this.httpClient.delete(`${this.API_URL}/delete/${id}`);
  }

  editReward(reward: any, id: any) {
    return this.httpClient.put(`${this.API_URL}/update/${id}`, reward);
  }
}
