import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Reward } from '../shared/Model/Reward';
import {
  RewardService,
} from '../shared/Service/Reward.service';

@Component({
  selector: 'app-reward',
  templateUrl: './reward.component.html',
  styleUrls: ['./reward.component.css'],
})
export class RewardComponent implements OnInit {
  listRewards: any;
  reward!: Reward;
  res:any;
  closeResult!: string;
  form: boolean = false;

  constructor(
    private rewardservice: RewardService,
    private modalService: NgbModal
  ) {}


  ngOnInit(): void {
    this.getAllRewards();
    this.reward = {
      id: null,
      name: null,
      quantity: null,
    };
  }

  getAllRewards() {
    this.rewardservice.getAllRewards().subscribe((res) => {
      this.res = res;
      console.log(res);
      this.listRewards = this.res;
      console.log(this.listRewards);
    });
  }

  addReward(reward:any) {
    delete reward.id;
    this.rewardservice.addReward(reward).subscribe((res) => {
      this.getAllRewards();
      this.form = false;
    });
  }

  updateReward(reward: any) {
    this.rewardservice.editReward(reward, reward.id).subscribe((res) => {
      this.getAllRewards();
      this.form = false;
    });
  }
  deleteReward(id: any) {
    this.rewardservice.deleteReward(id).subscribe((res) => {
      this.getAllRewards();
    });
  }

  open(content: any, action: any, id: any) {
    if(action != null) {
      this.reward = action;
      this.reward.id = id;
    } else this.reward = new Reward();
    this.modalService
    .open(content, { ariaLabelledBy: 'modal-basic-title' })
    .result.then(
      (result) => {
        this.closeResult = `Closed with: ${result}`;
      }
    )

  }

  cancel() {
    this.form = false;
  }
}
