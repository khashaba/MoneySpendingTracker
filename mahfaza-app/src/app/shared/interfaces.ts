export interface ICategory {
    id: number;
    name: string;
}
export interface IItem {
    id: number;
    name: string;
    categoryId:number;
}