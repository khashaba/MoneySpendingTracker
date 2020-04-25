import { Component, OnInit, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ICategory, IItem, IRecord } from '../shared/interfaces';
import { DataService } from '../core/data.service'
import { from } from 'rxjs';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  categories: ICategory[];
  items: IItem[];
  constructor(private dataService: DataService) { }
  entryAmount: number;
  description: string;
  categoryId:number;
  itemId:number;

  ngOnInit(): void {
    this.dataService.getCategories().subscribe((returnedCategories: ICategory[]) => this.categories = returnedCategories);
  }
  getItems(id: any) {
    this.dataService.getItems(id).subscribe((returnedItems: IItem[]) => this.items = returnedItems);
    this.categoryId=id
  }
  selectedItem(id: any){
    this.itemId=id;
  }

  submit() {
    const record:IRecord={
      amount:this.entryAmount,
      categoryId:this.categoryId,
      itemId:this.itemId,
      description:this.description,
      date:new Date
    }

    this.dataService.AddRecords(record).subscribe((res: IRecord) => console.log("done"));
    
  }
}
