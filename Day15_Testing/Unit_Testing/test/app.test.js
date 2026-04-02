const { describe, it} = require('mocha');
const add = require ('../app')

const {expect} = require('chai');

describe('testing math operations', () =>{
    beforeEach(() =>{
        console.log("Before each test this runs");
    
    })
    it("normal add", ()=>{
        const result = add(2,3);
        expect(result).to.equal(5);
    })
    it("normal add with negative values as parameters",()=>{
        const result = add(-2,-3);
        expect(result).to.equals(-5);
    })
})