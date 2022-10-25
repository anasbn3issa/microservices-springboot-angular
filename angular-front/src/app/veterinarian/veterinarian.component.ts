import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Sterilization } from '../shared/Model/Sterilization';
import { Veterinarian } from '../shared/Model/Veterinarian';
import { PetService } from '../shared/Service/pet.service';
import { SterilizationService } from '../shared/Service/sterilization.service';
import { VeterinarianService } from '../shared/Service/veterinarian.service';

@Component({
  selector: 'app-veterinarian',
  templateUrl: './veterinarian.component.html',
  styleUrls: ['./veterinarian.component.css']
})
export class VeterinarianComponent implements OnInit {
  listVeterinarian: any;
  res: any;
  veterinarian!: Veterinarian;
  closeResult!: string;
  form: boolean = false;
  pets : any = [];
  veterinarians : any = [];

  constructor(
    private sterilizationService: SterilizationService,
    private petService: PetService,
    private veterinarianService: VeterinarianService,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    //this.getAllSterilization()
    //this.getAllPets();
    this.getAllVeterinarians();

  }

 

  getAllVeterinarians(){
      this.veterinarianService.getAllVeterinarians().subscribe((res) => {
      this.veterinarians = res;      
    });
  }

   
  deleteVaccine(id: any) {
    this.veterinarianService
      .deleteVeterinarian(id)
      .subscribe((res) => this.getAllVeterinarians());
  }

  updateVaccine(p: any) {
    console.log(p);
    this.veterinarianService.editVeterinarian(p, p.id).subscribe(() => {
      this.getAllVeterinarians();
      this.form = false;
    });
  }

  addVaccine(vaccine: any) {
    console.log(vaccine);
    
    this.veterinarianService.addVeterinarian(vaccine).subscribe(() => {
      this.getAllVeterinarians();
      this.form = false;
    });
  }

  open(content: any, action: any, id: any) {
    if (action != null) {
      this.veterinarian = action
      /*this.vaccine = action;
      this.vaccine.id = id + 1;
      console.log(this.vaccine);
      console.log(id + 1);*/
    } else this.veterinarian = new Veterinarian();
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
