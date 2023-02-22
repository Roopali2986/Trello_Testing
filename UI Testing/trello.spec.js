describe('MyTestSuite',function()
{
  
    it('Login functionality - Automate', function()
    
    {
          cy.visit('https://trello.com/login')    /* Launch the webpage */
          cy.wait(2000)     /* Wait till the webpage loads completely  */ 

          cy.get('input[placeholder="Enter email"]').type("youremail") /*Enter your email ID*/
          cy.wait(2000)

          cy.get('input[value="Continue"]').click()    /* Click on Continue to navigate */
          cy.wait(2000)

          cy.origin('https://id.atlassian.com', () => {

          cy.get('input[name="password"]').type("yourpassword") /* Please provide your password */
          cy.get('button').contains('button','Log in').click()
          cy.go('forward')
          cy.wait(2000)
          cy.get('input[data-test-id="search-dialog-input]').type("Lunch prep")  /* This will allow you to type for search functionality*/ 

           })
        
    }   
    
    )

})