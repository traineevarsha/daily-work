import React,{useState} from "react";
import axios from "axios";
function OrderForm(){
    const [item,setItem] = useState("");
    const [price,setPrice] = useState("");
    const [orderLines,setOrderLines]= useState([]);
    const [message,setMessage] = useState("");
    const [quantity, setQuantity] = useState("");
    const handleAddOrderLine =()=>{
        if(!item.trim() || !price || !quantity){
            setMessage("please enter both feilds ");
            return;
        }
        const newOrderLine={
            item:item,
            price:Number(price),
            quantity: Number(quantity)
        };
        setOrderLines([...orderLines,newOrderLine]);
        setItem("");
        setPrice("");
        setMessage("");
        setQuantity("");
    };
    const handleRemoveOrderLine=(indexToRemove)=>{
        const updatedLines= orderLines.filter((_,index)=>index!==indexToRemove);
        setOrderLines(updatedLines);
    };
    const handleSubmitFinalOrder= async(event) => {
        event.preventDefault();
        if(orderLines.length ==0){
            setMessage("Add at least one order line before sumitting");
            return;
        }
        const payload = {
            orderLines:orderLines
        };
        console.log("Sending payload:", JSON.stringify(payload, null, 2));
           try {
      const response = await axios.post("http://localhost:8080/order",payload, {
        headers: {
          "Content-Type": "application/json"
        }});
      setMessage("Order saved successfully with id " + response.data);
      setItem("");
      setPrice("");
      setQuantity("");
      setOrderLines([]);
    } catch (error) {
      console.error(error);
      setMessage("Error while saving order");
    }};
    return(
    <div className="container">
        <h1>OMS Order Entry</h1>
        <div className="form-box">
            <label>Item</label>
            <input type="text"
                value={item}
                onChange={(event) => setItem(event.target.value)}
                placeholder="Enter item"/>
            <label>Price</label>
            <input type="number"
                value={price}
                onChange={(event) => setPrice(event.target.value)}
                placeholder="Enter price"/>
            <label>Quantity</label>
            <input type="number"
                value={quantity}
                onChange={(e) => setQuantity(e.target.value)}
                placeholder="Enter quantity"/>
            <button type="button" onClick={handleAddOrderLine}>Add OrderLine</button>
        </div>
        <h2>Order Lines</h2>
        {orderLines.length === 0 && <p>No order lines added yet</p>}
        {orderLines.length > 0 && (
            <ul className="order-line-list">
                {orderLines.map((line,index) => (
                    <li key={index} className="order-line-item">
                        <span>{line.item} - ₹{line.price} - Qty: {line.quantity}</span>
                        <button type="button" className="remove-btn" onClick={() => handleRemoveOrderLine(index)}>Remove</button>
                    </li>
                ))}
            </ul>
        )}
        <button
            className="final-submit-btn"
            type="button"
            onClick={handleSubmitFinalOrder}>
            Submit Final Order
        </button>
        {message && <p className="message">{message}</p>}
    </div>
);
}
export default OrderForm;