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
            1000); // every 1000 ms = 1 sec

    }

    // TASK-3 (Challenge) : Enhance the Timer component to stop after 15 secs.
    shouldComponentUpdate(nextProps, nextState) {
        console.log("In Timerc shouldComponentUpdate() LC method ");

        // don't render beyond 15 secs
        if (nextState.seconds > 15) {
            clearInterval(this.interval);
            return false; // false means don't invoke render method.
        }
        else return true; // call render method

    }

    // when the component goes out of sight, this LC will get called.
    componentWillUnmount() {
         console.log("In Timerc componentWillUnmount() LC method ");
        //clearInterval(this.interval);
    }


    render() {

        console.log("In Timerc render() LC method ")

        return (
            <div style={{ border: "1px solid green", padding: "4px", margin: "10px" }}>
                <h3>Timer</h3>
                Seconds: {this.state.seconds}
            </div>
        );
    }


}


export default Timer;