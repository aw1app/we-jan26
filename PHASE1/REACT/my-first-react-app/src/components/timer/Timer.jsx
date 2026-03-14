import { Component } from "react";


class Timer extends Component {


    constructor(props) {
        super(props);

        console.log("In Timerc Constructor ")

        this.state = {
            seconds: 0
        };

    }

    componentDidMount() {
        console.log("In Timerc componentDidMount() LC method ");

        // start the timer:
        this.interval = setInterval(
            () => {
                this.setState(
                    prevState => ({
                        seconds: prevState.seconds + 1
                    }));
            },
            1000);

    }


    render() {

        console.log("In Timerc render() LC method ")

        return (
            <div style={{ border: "1px solid blue", padding: "10px" }}>
                <h3>Timer</h3>
                Seconds: {this.state.seconds}
            </div>
        );
    }


}


export default Timer;