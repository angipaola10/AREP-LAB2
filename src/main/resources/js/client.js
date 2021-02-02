client = (function (){
    const calculate = (values, mean, standardDeviation) => {
        if ( mean || standardDeviation ) {
            if ( validate(values) ) {
                $("#stdResult").html('');
                $("#meanResult").html('');
                document.getElementById("divResult").style.visibility = 'visible';
                if (mean){
                    postAndShowMean(values);
                }
                if (standardDeviation){
                    postAnsShowStd(values);
                }
            } else {
                swal({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'The input is not correct',
                })
            }
        }else{
            swal({
                icon: 'warning',
                title: 'Oops...',
                text: 'Select an operation',
            })
        }
    }

    const postAndShowMean = (values) =>{
        fetch("calculator/mean", {
            method: 'POST',
            body:  values
        })
            .then( res => res.json())
            .catch(error => {
                swal({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong. Check your input and try again.',
                })
            })
            .then(  resp  => {
                $("#meanResult").html( 'Arithmetic mean: <small class=\"text-muted\">' + JSON.parse(resp).mean + '</small>' );
                document.getElementById("meanResult").style.visibility = 'visible';
            });
    }

    const postAnsShowStd = (values) =>{
        fetch("calculator/standardDeviation", {
            method: 'POST',
            body:  values
        })
            .then( res => res.json())
            .catch(() => {
                swal({
                    icon: 'error',
                    title: 'Oops...',
                    text: 'Something went wrong. Check your input and try again.',
                })
            })
            .then(  resp  => {
                $("#stdResult").html( 'Standard deviation: <small class=\"text-muted\">' + JSON.parse(resp).std + '</small>' );
                document.getElementById("stdResult").style.visibility = 'visible';
            });
    }

    const validate = (values) => {
        let list = values.split(",");
        console.log(list.length);
        let isValid = values !== "" && list.length > 1;
        if (isValid) {
            list.map(value => {
                if ( isNaN(value) ) {
                    isValid = false;
                }
            });
        }
        return isValid;
    }

    return{
        calculate: calculate
    }

})();