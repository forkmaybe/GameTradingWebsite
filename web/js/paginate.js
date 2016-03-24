(function($){

       $.fn.customPaginate = function(options)
       {
           var paginationContainer = this;
           var itemsToPaginate;
           
           var defaults = {
       
                itemsPerPage : 5
           
           };
        
           var settings = {};
           $.extend(settings, defaults, options);
           var itemsPerPage = settings.itemsPerPage;
           itemsToPaginate = $(settings.itemsToPaginate);
           var numberOfPaginationLinks = Math.ceil((itemsToPaginate.length / itemsPerPage));
        
           $("<ul></ul>").prependTo(paginationContainer);
           
           for(var index = 0; index < numberOfPaginationLinks; index++)
           {//have css to make the list nice
                paginationContainer.find("ul").append("<li class='paginateList'><a class='paginate'>"+ (index+1) + "</a></li>");
           }
           
           itemsToPaginate.filter(":gt(" + (itemsPerPage - 1)  + ")").hide();
           //when you click?
           paginationContainer.find("ul li").on('click', function(){
           
               var linkNumber = $(this).text();
               
                var itemsToHide = itemsToPaginate.filter(":lt(" + ((linkNumber-1) * itemsPerPage)  + ")");
                $.merge(itemsToHide, itemsToPaginate.filter(":gt(" + ((linkNumber * itemsPerPage) - 1)  + ")"));
                itemsToHide.hide();//hide
                
                var itemsToShow = itemsToPaginate.not(itemsToHide);
                itemsToShow.show();//show
           });
           
       };
            
}(jQuery));