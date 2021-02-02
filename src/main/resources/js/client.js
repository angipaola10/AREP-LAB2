const calculate = (values, mean, standardDeviation) => {
    if ( mean || standardDeviation ) {
        if ( validate(values) ) {
            if (mean){
                fetch("/calculator/mean", {
                    method: 'POST',
                    body: values,
                    headers:{
                        'Content-Type': 'text/html;charset=utf-8'
                    }
                })
                    .then( resp => {
                        //
                    })
                    .catch ( err => {
                        //
                    });
            }
            if (standardDeviation){
                fetch("/calculator/standardDeviation", {
                    method: 'POST',
                    body: values,
                    headers:{
                        'Content-Type': 'text/html;charset=utf-8'
                    }
                })
                    .then( resp => {
                        //
                    })
                    .catch ( err => {
                        //
                    });
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

const validate = (values) => {
    let list = values.split(",");
    let isValid = values !== "";
    list.map(value => {
        if (isNaN(value)){
            isValid = false;
        }
    });
    return isValid;
}