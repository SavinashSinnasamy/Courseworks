//-------------------------To validate forms-----------------------------------
function formCheck(event){

    var cnt=0; //To decide whether to submit or not

    //getting the value of each id
    let fName = document.getElementById("fname").value;
    let lName = document.getElementById("lname").value;
    let phone = document.getElementById("telephone").value; 

    //To check if name contains only alphabets
    if (!/^[A-Za-z\s]+$/.test(fName)){
        document.getElementById("fname").style.borderColor="#720c0c";
        //To display the warningBox
        warningBox();
        cnt++;

    } else if (!/^[A-Za-z\s]+$/.test(lName)){
        document.getElementById("lname").style.borderColor="#720c0c";
        warningBox();
        cnt++;

    } else{
        document.getElementById("fname").style.borderColor="#95df1d";
        document.getElementById("lname").style.borderColor="#95df1d";
        document.getElementById("warningName").style.display = "none";
        document.getElementById("incorrectName").style.display = "none";
    }

    //To check if input contains only numbers
    if (phone.length>0 && !/^[0-9]+$/.test(phone)){
        document.getElementById("telephone").style.borderColor="#720c0c";
        document.getElementById("warningTel").style.display="block";
        document.getElementById("incorrectTel").style.display="block";
        cnt++;
    } else{
        document.getElementById("telephone").style.borderColor="#95df1d";
        document.getElementById("warningTel").style.display = "none";
        document.getElementById("incorrectTel").style.display = "none";
    }

    //To check if the user has rated
    let radioButton = document.getElementsByName("star");
    let isChecked = false;
    for (let x = 0; x < radioButton.length; x++) {
        if (radioButton[x].checked) {
            isChecked = true;
            break;
        }
    }

    if (isChecked) {
        document.getElementById("warningRate").style.display = "none";
        document.getElementById("incorrectRate").style.display = "none";
    } else {
        document.getElementById("warningRate").style.display = "block";
        document.getElementById("incorrectRate").style.display = "block";
        cnt++;
    }

    if (cnt>0){ //stopping submission process to recorrect the errors made by the user
        event.preventDefault();
    }
    else{
        event.preventDefault(); //stopping the regular process to edit 'mailto' output format

        const fname = document.getElementById("fname").value;
        const lname = document.getElementById("lname").value;
        const email = document.getElementById("email").value; 
        const phone = document.getElementById("telephone").value; 
        const device = document.getElementById("device").value; 
        const comment = document.getElementById("comment").value;

        let star = document.getElementsByName("star");
        for (let x=0; x<star.length; x++){
            if (star[x].checked){
                var rating = star[x].value; //To get the value out of the loop
                break; 
            }
        }
        
        // Construct email body
        const emailBody =`First Name- ${fname}%0D%0ALast Name - ${lname}%0D%0AEmail - ${email}%0D%0ATelephone - ${phone}%0D%0ADevice used - ${device}%0D%0ARatings: ${rating} star%0D%0AComments: ${comment}%0D%0A%0D%0A` ;

        // Set email body in mailto URL
        const mailTo = `mailto:hasmithank@outlook.com?subject=Comments, Rating and User Details%20Details&body=${emailBody}`;

        // Open default email client with pre-filled email details
        window.location.href = mailTo;

        //Displaying a thank you note while hiding the form
        document.getElementById("commentText").style.display="none";
        document.getElementById("formContainer").style.display="none";
        document.getElementById("thankYou").style.display="block";
    }
}

function warningBox(){
    //To display the warningBox
    document.getElementById("warningName").style.display="block";
    document.getElementById("incorrectName").style.display="block";
}

function warningBox1(){
    //To display the warningBox
    document.getElementById("warningTel").style.display="block";
    document.getElementById("incorrectTel").style.display="block";
}

function colorChange(imageNum){
    //Function to shift between coloured star image and uncoloured star images
    for(let x=1; x<6; x++){
        if (x<imageNum){
            document.images[x].src="S2_Images/Coloured.png";
        }
        else{
            document.images[x].src="S2_Images/Uncoloured.png";
        }
    }
}

function defaultStar(){
    //Function to set all the stars default colours
    for(let x=1; x<6; x++){
        document.images[x].src="S2_Images/Uncoloured.png";
    }

    document.getElementById("fname").style.borderColor="#95df1d";
    document.getElementById("lname").style.borderColor="#95df1d";
    document.getElementById("warningName").style.display = "none";
    document.getElementById("incorrectName").style.display = "none";

    document.getElementById("telephone").style.borderColor="#95df1d";
    document.getElementById("warningTel").style.display = "none";
    document.getElementById("incorrectTel").style.display = "none";

    document.getElementById("warningRate").style.display = "none";
    document.getElementById("incorrectRate").style.display = "none";
}