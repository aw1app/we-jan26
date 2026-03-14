import { Component } from "react";

class ProductC extends Component {
    conversionRate = 20;

    constructor(props) {
        super(props);

        // this.state.name = props.name;
        // this.state.price = Number(props.price);

        this.state = {
            name: props.name,
            price: Number(props.price)
        };

        this.changePrice = this.changePrice.bind(this);
    }


    changePrice() {
        console.log("inside changePrice() of Product C");
        console.log("before updating by 1000 this.price=", this.state.price);

        // this.state.price = this.state.price + 1000; // directly changing state's data won't work in React. 
        // use the below appraoch to change data in state.
        this.setState(
            {
                ...this.state,
                price: this.state.price + 1000
            }
        );

        console.log("after 1000 this.price=", this.state.price);
    }

    render() {

        console.log("this.state.price=", this.state.price);

        return (

            <div style={{ "border": "solid 1px red" }}>

                Name : {this.props.name}, Price: INR {this.state.price}

                <button onClick={this.changePrice}> Change Price </button>
            </div >
        )
    }

};

export default ProductC;
