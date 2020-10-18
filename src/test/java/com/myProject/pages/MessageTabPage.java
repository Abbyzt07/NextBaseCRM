package com.myProject.pages;

import com.myProject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageTabPage extends BasePage{

    public MessageTabPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#post-buttons-bottom>#bx-b-uploadfile-blogPostForm")
    public WebElement uploadFilesIcon;

    @FindBy(css = "span[class*='bxhtmled-button-link']>i")
    public WebElement linkIcon;

    @FindBy(css = "span[class*='bxhtmled-button-video']>i")
    public WebElement insertVideoIcon;

    @FindBy(css = "span[class*='bxhtmled-button-quote']>i")
    public WebElement quoteTextIcon;

    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMentionIcon;

    @FindBy(css = "#bx-b-tag-input-blogPostForm")
    public WebElement addTagIcon;

    @FindBy(xpath = "(//span[text()='Record Video'])[1]")
    public WebElement recordVideo;

    @FindBy(xpath = "//span[@id='lhe_button_editor_blogPostForm']")
    public WebElement visualEditorIcon;

    @FindBy(id = "lhe_button_title_blogPostForm")
    public WebElement topicIcon;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(id = "blog-submit-button-cancel")
    public WebElement cancelButton;

    @FindBy(xpath = "(//div[@class='diskuf-uploader'])[1]")
    public WebElement uploadFilesandImages;

}
