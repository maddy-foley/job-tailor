export interface candidate {
    //FIX capitalization need to match backend?
    firstName: string,
    lastName: string,
    address: {
        email: string,
        phone: string,
        city: string,
        zipCode: number,
        country: string,
        state: string,
        streetAddress: string
    }
}
