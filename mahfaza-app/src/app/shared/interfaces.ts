export interface ICategory {
    id: number;
    name: string;
}
export interface IItem {
    id: number;
    name: string;
    categoryId:number;
}
export interface IRecord {
    id?:number
    amount: number;
    itemId: number;
    categoryId:number;
    description:string;
    date:Date;
}