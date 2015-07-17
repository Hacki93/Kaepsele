$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>');
            }
            else
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
            }
        })
    });


    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
    });
});



$(function() {

   //twitter bootstrap script

    $("button#frageSub").click(function(){

            $.ajax({

        type: "POST",

    url: "/SoftwarePraktikum/frageErst",

    data: $("#frageForm").serialize(),

            success: function(msg){

$("#Frage").empty();

           $("#Frage").modal('hide');

  

            },

    error: function(){

    alert("failure");

    }

          });

    });

   });

$(function() {

	   //twitter bootstrap script

	    $("button#themaSub").click(function(){

	            $.ajax({

	        type: "POST",

	    url: "/SoftwarePraktikum/beitragSchreiben",

	    data: $("#themaForm").serialize(),

	            success: function(msg){

	$("#Beitrag").empty();

	           $("#Beitrag").modal('hide');

	  

	            },

	    error: function(){

	    alert("failure");

	    }

	          });

	    });

	   });