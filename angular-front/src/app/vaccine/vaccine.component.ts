import { Component, OnInit } from '@angular/core';
import { Vaccine } from '../shared/Model/Vaccine';
import { VaccineService } from '../shared/Service/vaccine.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-vaccine',
  templateUrl: './vaccine.component.html',
  styleUrls: ['./vaccine.component.css'],
})
export class VaccineComponent implements OnInit {
  listVaccines: any;
  res: any;
  vaccine!: Vaccine;
  closeResult!: string;
  form: boolean = false;
  constructor(
    private vaccineservice: VaccineService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getAllVaccines();
    this.vaccine = {
      id: null,
      name: null,
      validity: null,
      quantity: null,
    };
  }

  getAllVaccines() {
    this.vaccineservice.getAllVaccines().subscribe((res) => {
      this.res = res;
      console.log(res);
      this.listVaccines = this.res._embedded.vaccines;
      console.log(this.listVaccines);
    });
  }

  deleteVaccine(id: number) {
    console.log(id + 1);
    this.vaccineservice
      .deleteVaccine(id + 1)
      .subscribe(() => this.getAllVaccines());
  }
  updateVaccine(p: any) {
    console.log(p);
    this.vaccineservice.editVaccine(p, p.id).subscribe(() => {
      this.getAllVaccines();
      this.form = false;
    });
  }

  addVaccine(vaccine: any) {
    console.log(vaccine);
    delete vaccine.id;
    console.log(vaccine);
    this.vaccineservice.addVaccine(vaccine).subscribe(() => {
      this.getAllVaccines();
      this.form = false;
    });
  }

  open(content: any, action: any, id: any) {
    if (action != null) {
      this.vaccine = action;
      this.vaccine.id = id + 1;
      console.log(this.vaccine);
      console.log(id + 1);
    } else this.vaccine = new Vaccine();
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
