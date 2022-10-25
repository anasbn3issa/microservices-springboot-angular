import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Sterilization } from '../shared/Model/Sterilization';
import { PetService } from '../shared/Service/pet.service';
import { SterilizationService } from '../shared/Service/sterilization.service';
import { VeterinarianService } from '../shared/Service/veterinarian.service';

@Component({
  selector: 'app-sterilization',
  templateUrl: './sterilization.component.html',
  styleUrls: ['./sterilization.component.css']
})
export class SterilizationComponent implements OnInit {
  listSterilization: any;
  res: any;
  sterilization!: Sterilization;
  closeResult!: string;
  form: boolean = false;
  pets : any = [];
  veterinarians : any = [];
  


  constructor(
    private sterilizationService: SterilizationService,
    private petService: PetService,
    private veterinarianService: VeterinarianService,
    private modalService: NgbModal
  ) { 
    
  }

  ngOnInit(): void {
    this.getAllSterilization()
    this.getAllPets();
    this.getAllVeterinarians();

  }

  getAllPets(){
      this.petService.getAllPets().subscribe((res) => {
        
      this.pets = res;      
    });
  }

  getAllVeterinarians(){
      this.veterinarianService.getAllVeterinarians().subscribe((res) => {
      this.veterinarians = res;      
    });
  }

   getAllSterilization() {
    this.sterilizationService.getAllSterilizations().subscribe((res) => {
      this.res = res;
      console.log(res);
      this.listSterilization = res;
      
    });
  }

  deleteVaccine(id: any) {
    this.sterilizationService
      .deleteSterilization(id)
      .subscribe((res) => this.getAllSterilization());
  }
  updateVaccine(p: any) {
    console.log(p);
    this.sterilizationService.editSterilization(p, p.id).subscribe(() => {
      this.getAllSterilization();
      this.form = false;
    });
  }

  addVaccine(vaccine: any) {
    console.log(vaccine);
    
    this.sterilizationService.addSterilization(vaccine).subscribe(() => {
      this.getAllSterilization();
      this.form = false;
    });
  }

  open(content: any, action: any, id: any) {
    if (action != null) {
      this.sterilization = action
      /*this.vaccine = action;
      this.vaccine.id = id + 1;
      console.log(this.vaccine);
      console.log(id + 1);*/
    } else this.sterilization = new Sterilization();
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
