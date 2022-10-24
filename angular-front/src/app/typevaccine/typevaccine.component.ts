import { Component, OnInit } from '@angular/core';
import { Vaccine } from '../shared/Model/Vaccine';
import { VaccineService } from '../shared/Service/vaccine.service';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { TypeVaccine } from '../shared/Model/TypeVaccine';
import { TypeVaccineService } from '../shared/Service/typevaccine.service';

@Component({
  selector: 'app-typevaccine',
  templateUrl: './typevaccine.component.html',
  styleUrls: ['./typevaccine.component.css'],
})
export class TypevaccineComponent implements OnInit {
  listTVaccines: any;
  res: any;
  tvaccine!: TypeVaccine;
  closeResult!: string;
  form: boolean = false;
  constructor(
    private tvaccineservice: TypeVaccineService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.getAllVaccines();
    this.tvaccine = {
      id: null,
      type: null,
      duration: null,
    };
  }

  getAllVaccines() {
    this.tvaccineservice.getAllTVaccines().subscribe((res) => {
      this.res = res;
      console.log(res);
      this.listTVaccines = this.res._embedded.vaccineTypes;
      console.log(this.listTVaccines);
    });
  }

  deleteVaccine(id: number) {
    console.log(id + 1);
    this.tvaccineservice
      .deleteTVaccine(id + 1)
      .subscribe(() => this.getAllVaccines());
  }
  updateVaccine(p: any) {
    console.log('fel update');
    console.log(p);
    this.tvaccineservice.editTVaccine(p, p.id).subscribe(() => {
      this.getAllVaccines();
      this.form = false;
    });
  }

  addVaccine(tvaccine: any) {
    console.log(tvaccine);
    delete tvaccine.id;
    console.log(tvaccine);
    this.tvaccineservice.addTVaccine(tvaccine).subscribe(() => {
      this.getAllVaccines();
      this.form = false;
    });
  }

  open(content: any, action: any, id: any) {
    if (action != null) {
      this.tvaccine = action;
      this.tvaccine.id = id + 1;
      console.log(this.tvaccine);
      console.log(id + 1);
    } else this.tvaccine = new TypeVaccine();
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
