

const Product = (props) => {
    // returning JSX
    return (
        <div style={{"border":"solid 1px blue"}}>
          {props.name}, {props.price}, 
            
        </div>
    )
}

export default Product;


