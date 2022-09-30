import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { PizzaService } from '../pizza.service';
import { Order } from '../models';
import { HttpErrorResponse } from '@angular/common/http';

const SIZES: string[] = [
  "Personal - 6 inches",
  "Regular - 9 inches",
  "Large - 12 inches",
  "Extra Large - 15 inches"
]

const PizzaToppings: string[] = [
    'chicken', 'seafood', 'beef', 'vegetables',
    'cheese', 'arugula', 'pineapple'
]

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  form!: FormGroup
  toppings!: FormArray

  labels = ['chicken', 'seafood', 'beef', 'vegetables', 'cheese', 'arugula', 'pineapple']


  pizzaSize = SIZES[0]

  constructor(private fb: FormBuilder, private pizzaSvc: PizzaService) { }


  ngOnInit(): void {
    
    this.toppings = this.fb.array(this.labels.map(()=>this.fb.control('', [ Validators.required ]))
    )

    this.form = this.fb.group({
      name: this.fb.control<string>('', [ Validators.required, Validators.minLength(3) ]),
      email: this.fb.control<string>('', [ Validators.required, Validators.email ]),
      size: this.fb.control<number>  (0, [ Validators.required, Validators.max(3), Validators.min(0) ]),
      base: this.fb.control<string>('thin', [ Validators.required ]),
      sauce: this.fb.control<string>('classic', [ Validators.required ]),
      toppings: this.toppings,
      comments: this.fb.control<string>(''),
    })
    
  }

  updateSize(size: string) {
    this.pizzaSize = SIZES[parseInt(size)]
  }
  

  processForm() {
    const order: Order = this.form.value as Order
    //this.pizzaSvc.createOrder(order)

    //const email = this.form.get('email')?.value

    
  }
}
