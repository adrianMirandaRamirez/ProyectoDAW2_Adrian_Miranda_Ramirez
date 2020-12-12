(function () {
    $("[data-translate]").jqTranslate('json/index', {defaultLang: 'es'});
})();

$(document).ready(function(){
    
    $("#espania").on('click',function(event){
        
            $("[data-translate]").jqTranslate('json/index',{defaultLang:'en',forceLang:"es", asyncLangLoad:false});
        
    });
    
    $("#reinoUnido").on('click',function(event){
        
            $("[data-translate]").jqTranslate('json/index',{defaultLang:'es',forceLang:"en", asyncLangLoad:false});
        
    });
    
    $("#alemania").on('click',function(event){
        
            $("[data-translate]").jqTranslate('json/index',{defaultLang:'es',forceLang:"de", asyncLangLoad:false});
       
    });
    
    $("#italia").on('click',function(event){
        
            $("[data-translate]").jqTranslate('json/index',{defaultLang:'es',forceLang:"ti", asyncLangLoad:false});
        
    });
});
