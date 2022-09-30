// Add your models here if you have any
export interface Order {
	name: string
	email: string
    size: number
    base: string
    sauce: string
    toppings: []
    comments: string
    orderId?: string
}