import { Component, OnInit } from '@angular/core';
import { Local } from '../shared/Model/Local';
import { LocalService } from '../shared/Service/Local.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-local',
  templateUrl: './local.component.html',
  styleUrls: ['./local.component.css'],
})
export class LocalComponent implements OnInit {
  listLocals: any;
  res: any;
  local!: Local;
  closeResult!: string;
  form: boolean = false;
  constructor(
    private localservice: LocalService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getAllLocals();
    this.local = {
      id: null,
      name: null,
      address: null,
      status: null,
    };
  }

  getAllLocals() {
    this.localservice.getAllLocals().subscribe((res) => {
      this.res = res;
      console.log(res);
      this.listLocals = this.res._embedded.locals;
      console.log(this.listLocals);
    });
  }

  deleteLocal(id: number) {
    console.log(id + 1);
    this.localservice.deleteLocal(id + 1).subscribe(() => this.getAllLocals());
  }
  updateLocal(p: any) {
    console.log(p);
    this.localservice.editLocal(p, p.id).subscribe(() => {
      this.getAllLocals();
      this.form = false;
    });
  }

  addLocal(local: any) {
    console.log(local);
    delete local.id;
    console.log(local);
    this.localservice.addLocal(local).subscribe(() => {
      this.getAllLocals();
      this.form = false;
    });
  }

  open(content: any, action: any, id: any) {
    if (action != null) {
      this.local = action;
      this.local.id = id + 1;
      console.log(this.local);
      console.log(id + 1);
    } else this.local = new Local();
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  cancel() {
    this.form = false;
  }
}
