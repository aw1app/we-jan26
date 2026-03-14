import { Component } from "react";

class ProductC extends Component {
     conversionRate = 20;

    constructor(props) {
        super(props);
    }


    render() {

        return (

            < div style={{ "border": "solid 1px red" }}>

                Name : {this.props.name}, Price: INR {this.props.price * this.conversionRate}
            </div >
        )
    }

};

export default ProductC;