
//array of quiz question blocks
var question_box = document.getElementById("question_container").querySelectorAll(".question");
//array of quiz answer buttons
var question_box_btn = document.getElementById("question_container").getElementsByTagName("button");


var correct_no_of_answers = 0;
var current_index;

// add function to quiz starting button
document.getElementById("quiz_start_btn").addEventListener("click",function(){ 
    quiz_start(question_box) 
    timer();
} );

//  add function to quiz finish button
document.getElementById("quiz_finish_btn").addEventListener("click",finish_quiz);

//  add function to next button
document.getElementById("quiz_next_btn").addEventListener("click",function(){next_question(question_box,this.id)});


//hide all questions
for(var i=0;i<10 ; i++){
    question_box[i].style.display="none";
}
//hide the timer and navigation button
document.getElementById("quiz_finish_btn").style.display="none";
document.getElementById("quiz_next_btn").style.display="none";
document.getElementById("main_timer_container").style.display="none";

//add eventlisteners to all answer buttons
for(var j=0; j<question_box_btn.length ; j++){
    question_box_btn[j].addEventListener("click",function(){ 
        this.classList.add("given_answer")
        next_question(question_box,this.id) 
    });
}

        // timer starting function
function timer(){
    var time = (1*60*1000);
    timer_calculation(time);
    var timeRemaining = time - 1000;
    var timer = setInterval(function(){
        timer_calculation(timeRemaining);
        timeRemaining = timeRemaining - 1000; 
        if(timeRemaining==-1000){
            clearInterval(timer)
            display_timeout();
            finish_quiz()
            document.getElementById("main_timer_container").style.display="block";
        }
    },1000) 
}


        //function for calculating and displaying remaining time
function timer_calculation(timeRemaining){   
    var time_In_Minutes = parseInt((timeRemaining/1000)/60);
    var time_In_Seconds = (timeRemaining/1000)%60;
    document.getElementById("time").innerHTML = time_In_Minutes+" : "+time_In_Seconds;
}


        //function for display timeout message
function display_timeout(){
    document.getElementById("main_timer_container").innerHTML="<span id='time'> OOPS! <br><br><br> Times' Out! </span>";

}

        // function for validate given answer
function validate_answer(id){
    if(id=="answer"){
        correct_no_of_answers=correct_no_of_answers+2;
    }
}

        //move to next question
function next_question(question_box,id){
    if(current_index<=8){
        validate_answer(id);
        question_box[current_index].style.display="none";
        question_box[current_index+1].style.display="block";
        current_index=current_index+1;
    }else{
        validate_answer(id);
        finish_quiz();
        clearInterval(timer);
        document.getElementById("time").innerHTML="10:00"
    }
}

        // questionnaire starting function
function quiz_start(question_box){
    for(var i=0;i<10 ; i++){
        question_box[i].style.display="none";
    }
    question_box[0].style.display="block";
    positioning();
    current_index=0;
    correct_no_of_answers=0;
}

        //content positioning on starting the function
function positioning(){
    document.getElementById("quiz_start_btn").style.display="none";
    document.getElementById("quiz_finish_btn").style.display="block";
    document.getElementById("quiz_next_btn").style.display="block";
    document.getElementById("main_timer_container").style.display="block";

    var content_left = document.getElementById("left_content");
    content_left.style.opacity="0";
    content_left.style.transform='translateX(-200px)';
}

        
        //questionnaire finishing function

function finish_quiz(){
    document.getElementById("question_container").style.display="none";
    document.getElementById("main_timer_container").style.display="none";
    document.getElementById("score_board").style.display="block";
    document.getElementById("score_display").innerHTML=correct_no_of_answers;
    document.getElementById("view_performance").style.display="block"


    document.getElementById("quiz_report").style.display="block";
    for(var k=0;k<10;k++){
        var duplicate = question_box[k].cloneNode(true);
        document.getElementById("quiz_report").appendChild(duplicate);
        duplicate.style.display="block";
    }

    chance_background_color()
}


        // change background color
function chance_background_color(){
    var background = document.getElementById('quiz_main');
    background.style.color='#000000';
    if(correct_no_of_answers<10){
        background.style.backgroundColor="red"
    }else if(correct_no_of_answers<15){
        background.style.backgroundColor="greenyellow"
    }else{
        background.style.backgroundColor="green"
    }
}

