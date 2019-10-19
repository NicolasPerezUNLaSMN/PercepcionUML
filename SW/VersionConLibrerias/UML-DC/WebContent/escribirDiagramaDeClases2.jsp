<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    <%@page import="test.PrimerDiagrama"%>
     <%@page import="datos.Clase"%>
     
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>



<head>
<title>Inicio visual a DC</title>



	<title>PlantText UML Editor</title>
	<meta charset="UTF-8">
	<meta name="author" content="Arwen Vaughan" />
	<meta name="keywords" content="PlantText,PlantUML,UML Design Software,Architect,Unified Modeling Language,Design Patterns,Networking,IT" />
	<meta name="description" content="PlantText is an online tool that quickly generates images from text. Primarily, it is used to generate UML (Unified Modeling Language) diagrams. It is based on a text language called PlantUML." />
	<meta name="viewport" content="width=device-width, initial-scale=0.5">

	<link href="css/styles.css?v=13.6" rel="stylesheet" type="text/css" />
	<link href="js/jquery-ui-1.8.24/themes/base/minified/jquery-ui.min.css" rel="stylesheet" type="text/css"/>

	<script type="text/javascript" src="js/jquery-1.5.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.8.24/ui/minified/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/jquery-plantuml/rawdeflate.min.js?v=13.6"></script>
	<script type="text/javascript" src="js/jquery-plantuml/rawinflate.min.js?v=13.6"></script>
	<script type="text/javascript" src="js/jquery-plantuml/plantuml.min.js?v=13.6"></script>
	<script type="text/javascript" src="js/ace-1.1.2/ace.js"></script>
	


	

	
</head>



<body>

	!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5J88DV3"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	<div id="header">
		<div id="header-left">
			<img id="logoimage" src="images/blue_gray.png" alt="PlantText" height="35" width="35">
			<span id="logotext" title="The expert's design tool">PlantText</span><span id="logotextmsg">- The expert's design tool</span>
		</div>
		<div id="header-right">
			<div id="nav">
				<ul>
					<li><a href="http://blog.planttext.com/about" target="_blank">About</a></li>
					<li><a href="http://blog.planttext.com" target="_blank">Blog</a></li>
					<li><a href="http://blog.planttext.com/forum" target="_blank">Forum</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="body">
		<form>
		<div id="loader"></div>
		<div id="fademessage"></div>
		<div id="menu">
			<div id="menu-left">
				<select name="samples" id="samples">
					<option value="default">Select a sample...</option>
					<optgroup label="Activity Diagram">
						<option value="1">1 - Activity</option>
						<option value="2">2 - Conditional</option>
						<option value="3">3 - Notes</option>
						<option value="4">4 - Repeat</option>
						<option value="5">5 - While Loop</option>
						<option value="6">6 - Parallel</option>
						<option value="7">7 - Color</option>
					</optgroup>
					<optgroup label="Class Diagram">
						<option value="8">1 - Classes</option>
						<option value="9">2 - Relationships</option>
						<option value="10">3 - Types</option>
						<option value="11">4 - Properties / Methods</option>
						<option value="12">5 - Interfaces</option>
						<option value="13">6 - Packages</option>
					</optgroup>
					<optgroup label="Component Diagram">
						<option value="14">1 - Components</option>
						<option value="15">2 - Interfaces</option>
						<option value="16">3 - Packages</option>
						<option value="17">4 - Labels and Notes</option>
					</optgroup>
					<optgroup label="GraphViz Diagram">
						<option value="50">1 - Hello World</option>
						<option value="18">2 - World Dynamics</option>
						<option value="51">3 - Data Structures</option>
						<option value="52">4 - Graph Cluster Node Gradient</option>
					</optgroup>
					<optgroup label="Object Diagram">
						<option value="19">1 - Simple Object</option>
					</optgroup>
					<optgroup label="Salt GUI Diagram">
						<option value="20">1 - Basic Elements</option>
						<option value="21">2 - Grid</option>
						<option value="22">3 - Separators</option>
						<option value="23">4 - Tree View</option>
						<option value="24">5 - Brackets</option>
						<option value="25">6 - Tabs</option>
						<option value="26">7 - Menus</option>
					</optgroup>
					<optgroup label="Sequence Diagram">
						<option value="27">1 - Participants</option>
						<option value="28">2 - Messages</option>
						<option value="29">3 - Comments</option>
						<option value="30">4 - Message Styles</option>
					</optgroup>
					<optgroup label="State Diagram">
						<option value="31">1 - Simple State</option>
						<option value="32">2 - Simple Composite State</option>
						<option value="33">3 - Simple Orthogonal Composite State</option>
						<option value="34">4 - Concurrent State C3PO</option>
						<option value="35">5 - Arrows and Notes</option>
					</optgroup>
					<optgroup label="Use Case Diagram">
						<option value="36">1 - Use Cases</option>
						<option value="37">2 - Actors</option>
						<option value="38">3 - Connections</option>
						<option value="39">4 - Stereotypes</option>
						<option value="40">5 - Directions</option>
						<option value="41">6 - Package</option>
					</optgroup>
					<optgroup label="XEarth Diagram">
						<option value="42">1 - Basic</option>
						<option value="43">2 - Add Place</option>
						<option value="44">3 - Add More Stars</option>
						<option value="45">4 - Relative View From Sun</option>
						<option value="46">5 - Change Grid Configuration</option>
						<option value="47">6 - Fixed Position without Shading</option>
						<option value="48">7 - View From Moon Changing Luminacity</option>
						<option value="49">8 - Adding Cities</option>
					</optgroup>
				</select>
				<span title="Settings"><button type="submit" class="popupbuttons" onclick="openSettings(); return false;" style="vertical-align: middle;"><img src="/images/cog-2x.png" alt="Files"></button></span>
				<span title="Code"><button type="submit" class="popupbuttons" onclick="openCode(); return false;" style="vertical-align: middle;"><img src="/images/code-2x.png" alt="Code"></button></span>
				<span title="Scripting"><button type="submit" class="popupbuttons" onclick="openScripting(); return false;" style="vertical-align: middle;"><img src="/images/script-2x.png" alt="Script" ></button></span>
				<span title="Questions"><button type="submit" class="popupbuttons" onclick="openHelp(); return false;" style="vertical-align: middle;"><img src="/images/question-mark-2x.png" alt="Question" ></button></span>
			</div>
			<div id="menu-right">
				<div id="authorize" style="z-index:2000;">
					<img id="authorize-button" src="images/btn_google_signin_dark_normal_web.png" height="30" alt="Google Sign In Button">
				</div>
			</div>
		</div>
		<div id="main">
			<div id="sidebar">
				<div id="file-menu-dropdown">
					<span title="Manage files"><button id="file-menu-button" style="width:100px;" type="submit" onclick="openFileMenu(); return false;" disabled>File Manager</button></span>
					<div style="z-index:4000;" id="file-menu-list" class="file-menu-dropdown-content">
						<a href="#" onclick="openFileMenuNew(); return false;">New</a>
						<a href="#" onclick="openFileMenuOpen(); return false;">Open</a>
						<a href="#" onclick="submitFileMenuSave(); return false;">Save</a>
						<a href="#" onclick="openFileMenuSaveas(); return false;">Save As...</a>
						<a href="#" onclick="openFiles(); return false;">Import / Export</a>
						<a href="#" onclick="submitFileMenuDelete(); return false;">Delete</a>
					</div>
					<span title="Refresh (Alt + Enter)"><button id="refreshbutton" style="width:100px;" type="submit" onclick="refreshFromButton(); return false;">Refresh</button></span>
					<span id="file-name-output-pre">File:</span><span id="file-name-output"></span>
				</div>
				<div id="editor"></div>
			</div>
			<div id="content">
				<img id="im" src="/images/blue_gray.png" alt="PlantUML Diagram"><br /><br />
				<a id="plantimagelink" target="_blank" href="">PNG</a>&nbsp;|&nbsp;
				<a id="plantsvglink" target="_blank" href="">SVG</a>&nbsp;|&nbsp;
				<a id="planttxtlink" target="_blank" href="">TXT</a>&nbsp;|&nbsp;
				<a id="planteditorlink" target="_blank" href="">Edit</a>
			</div>
			<div id="addblock">
				<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- Right -->
				<ins class="adsbygoogle"
				     style="display:inline-block;width:120px;height:600px"
				     data-ad-client="ca-pub-1879544236387698"
				     data-ad-slot="9610488963"></ins>
				<script>
				(adsbygoogle = window.adsbygoogle || []).push({});
				</script>
			</div>
		</div>
		<div id="setting">
			<table style="border:0;width=100%">
				<tr>
					<td style="text-align:right;width:25%;">Layout:</td>
					<td>
						<input id="layout-portrait" type="radio" name="layout" value="portrait" onclick="portrait();" checked>Portrait
						<input id="layout-landscape" type="radio" name="layout" value="landscape" onclick="landscape();">Landscape
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">Theme:</td>
					<td>
						<select name="theme" id="theme" class="otherdrops" size="1" >
						<optgroup label="Bright">
							<option value="chrome">Chrome</option>
							<option value="clouds">Clouds</option>
							<option value="crimson_editor">Chrimson Editor</option>
							<option value="dawn">Dawn</option>
							<option value="dreamweaver">Dreamweaver</option>
							<option value="eclipse">Eclipse</option>
							<option value="github">GitHub</option>
							<option value="solarized_light">Solarized Light</option>
							<option value="textmate" selected="selected" >TextMate</option>
							<option value="tomorrow">Tomorrow</option>
							<option value="chrome">Chrome</option>
							<option value="xcode">XCode</option>
						</optgroup>
						<optgroup label="Dark">
							<option value="ambiance" >Ambiance</option>
							<option value="chaos" >Chaos</option>
							<option value="clouds_midnight" >Clouds Midnight</option>
							<option value="cobalt" >Cobalt</option>
							<option value="idle_fingers" >Idle Filgers</option>
							<option value="kr_theme" >krThems</option>
							<option value="merbivore" >Merbivore</option>
							<option value="merbivore_soft" >Merbivore Soft</option>
							<option value="mono_industrial" >Mono Industrial</option>
							<option value="monokai" >Monokai</option>
							<option value="pastel_on_dark" >Pastel on Dark</option>
							<option value="solarized_dark" >Solarized Dark</option>
							<option value="terminal" >Terminal</option>
							<option value="tomorrow_night" >Tomorrow Night</option>
							<option value="tomorrow_night_blue" >Tomorrow Night Blue</option>
							<option value="tomorrow_night_dark" >Tomorrow Night Dark</option>
							<option value="tomorrow_night_eighties" >Tomorrow Night 80s</option>
							<option value="twilight" >Twilight</option>
							<option value="vibrant_ink" >Vibrant Ink</option>
						</optgroup>
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">Bindings:</td>
					<td>
						<select name="keybinding" id="keybinding" class="otherdrops" size="1" >
							<option value="ace" selected="selected" >Normal</option>
							<option value="vim">Vim</option>
							<option value="emacs">Emacs</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">Font Size: </td>
					<td>
						<select name="fontsize" id="fontsize" class="otherdrops" size="1" >
							<option value="10" >10 px</option>
							<option value="11" >11 px</option>
							<option value="12" selected="selected" >12 px</option>
							<option value="13" >13 px</option>
							<option value="14" >14 px</option>
							<option value="16" >16 px</option>
							<option value="18" >18 px</option>
							<option value="20" >20 px</option>
							<option value="24" >24 px</option>
						</select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">Marks: </td>
					<td>
						<input name="invisibles" id="invisibles" type="checkbox" checked="checked" onclick="toggleVisibles();" >Show invisibles
						<input name="indentguide" id="indentguide" type="checkbox" checked="checked" onclick="toggleIndentGuide()" >Show indent guides
					</td>
				</tr>
				<tr>
					<td style="text-align:right;">
						<span title="This application uses a PlantUML server in order to generate the diagrams. If you have problems generating diagrams, please enter a different PlantUML server URL below. These servers have been known to go down from time to time. You can setup a server by reading the information. You can enter your own PlantUML server or revert by clicking 'Default'.">PlantUML Server:</span>
					</td>
					<td>
						<input class="otherbuttons" id="defaultserver" type="submit" value="Default" disabled onclick="defaultFromButton(); return false;">
						<input type="text" id="plantumlserver" value="" disabled >
						<a href="http://plantuml.sourceforge.net/server.html" target="_blank"><img id="infomark" align="middle" src="/images/info-2x.png" alt="PlantUML Server Info"></a>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<div style="text-align: center; width:100%;" title="Save one editor document to the cloud"><input id="savebutton" class="otherbuttons" type="submit" value="Save Settings" onclick="saveFromButton(); return false;" disabled></div><br />
					</td>
				</tr>
			</table>
		</div>
		<div id="code">
			<table style="border:0;width=100%">
				<tr>
					<td colspan="2" style="text-align:left;">
						Convert class diagrams to code stubs in one of he available programming languages.
						<br / ><br / >
						Special thanks to <a target="_blank" href="https://github.com/bafolts">Brian Folts</a> for building the conversion code.  If you want to help improve this feature please log issues <a id="planteditorlink" target="_blank" href="https://github.com/bafolts/plantuml-code-generator/issues">here</a>.
					 	<br /><br />
					</td>
				</tr>
				<tr>
					<td style="text-align:left;width:25%">
						<select name="language" id="language" class="otherdrops" size="1">
							<option value="coffeescript">Coffee Script</option>
							<option value="csharp">C Sharp</option>
							<option value="ecmascript5">ECMAScript 5</option>
							<option value="ecmascript6">ECMAScript 6</option>
							<option value="java">Java</option>
							<option value="php">PHP</option>
							<option value="ruby">Ruby</option>
							<option value="typescript">Type Script</option>
						</select>
					</td>
					<td>
						<input id="codebutton" class="otherbuttons" type="submit" value="Convert to Code" onclick="codeFromButton(); return false;">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<textarea name="codeoutput" id="codeoutput" rows="10"></textarea>
					</td>
				</tr>
		</table>
		<div id="scripting">
			<table style="border:0;width=100%">
				<tr>
					<td colspan="2" style="text-align:left;">
						Convert raw PlantUML text into a URL. The URL can then be copies into a browser in order to create the diagram image. This URL is useful when trying
						to put PlantUML diagrams into documents or uploading them to other websites. You can generate the URLs manually using the form below, or folow the
						link below to learn how to programmatically call a web endpoint and run this functionality automatically.
						<br /><br />
						<a target="_blank" href="https://www.planttext.com/api/scripting">Click Here</a>
						<br /><br />
					</td>
				</tr>
				<tr>
					<td style="text-align:left;width:20%">
						<select name="scriptingimagetype" id="scriptingimagetype" class="otherdrops" size="1">
							<option value="png">PNG</option>
							<option value="svg">SVG</option>
							<option value="txt">ASCI Text</option>
						</select>
					</td>
					<td>
						<input id="scriptingbutton" class="otherbuttons" type="submit" value="PlantUML to Link" onclick="urlFromPlantUML(); return false;">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<textarea name="scriptingoutput" id="scriptingoutput" rows="10"></textarea>
					</td>
				</tr>
			</table>
		</div>
		<div id="files">
			<table style="border:0;width=100%">
				<tr>
					<td style="text-align:right;width:25%;">
						Import:
					</td>
					<td style="text-align:left;">
						<input id="fileInput" type="file" onchange="importUML(); return false;">
					</td>
				</tr>
				<tr>
					<td style="text-align:right;width:25%;">
						Export:
					</td>
					<td style="text-align:left;">
						<input id="fileExport" class="otherbuttons" type="submit" value="Browse..." onclick="exportUML(); return false;">
					</td>
				</tr>
			</table>
		</div>
		<div id="help">
			<table style="border:0;width=100%">
				<tr>
					<td style="text-align:left;">
						PlantText is a text-based tool for quickly creating clear UML diagrams that can be compared, versioned, and managed. Simply type PlantUML language into the editor and refresh the screen to produce a professional diagram. Save, export, or copy the image for use in your requirements or design documents.
					</td>
				</tr>
				<tr>
					<td style="text-align:center;">
						<h2><a href="https://youtu.be/d8ABkAkT3q0" target="_blank">PlantText Video Tutorial</a></h2>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;">
						<span title=""><h2>Helpful Tips:</h2></span>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;">
						<ul>
							<li>Press the Alt + Enter keystroke combination to refresh the PlantUML diagram. This way you don't have to use your mouse to refresh at all.</li>	
							<li>A quick way to learn PlantUML is by working through the sample dropdown list. These PlantUML diagrams are grouped by diagram type and follow a natural progression. We will continue to add to this list over time.</li>	
							<li>If you login with your Google account, you can then use the "Save" button to store your PlantUML and other settings to the PlantText server. If you do this, your PlantUML will automatically load any time you login. You can press the "Load" button if you want to revert to the saved PlantUML and user settings.</li>
							<li>Use the 'Files' button to quickly export and import PlantUML as text files to and from your local file system. Be careful though because importing will copy the PlantUML in those files over any PlantUML you already have in the PlantText editor.</li>
							<li>The 'Settings' buttons contains user settings that affect the way the editor works and it's appearance. You can switch to VIM or Emacs mode if you are an old school unix geek.</li>			
							<li>If diagrams are not refreshing quickly or not at all, the PlantUML server may be slow or completely down. Use the 'Server' button to enter a URL to a different PlantUML server in order to make it work or speed it up. You can follow the instructions <a href="http://plantuml.sourceforge.net/server.html" target="_blank">here</a> in order to set your own PlantUML server up.</li>
						</ul>
					</td>
				</tr>
				<tr>
					<td style="text-align:left;">
						<p>Finally, if you are using Google Docs you may want to try our Google Docs Addon...</p>
						<h2><img src="images/new.png" alt="New" width="30" style="vertical-align: middle; display: inline-block;"> <a href="https://chrome.google.com/webstore/detail/planttext/lcnoppmgehpmddfmhlnajmchlgkmpaoj?hl=en" target="_blank">Add-on for Google Docs</a></h2>
					</td>
				</tr>
			</table>
		</div>
		<div id="newspop">
			<table style="border:0;width=100%">
				<tr>
					<td style="text-align:left;">
						<img src="images/new.png" alt="New" width="25" style="align:left; display: inline-block;">
						<p>Announcing some big improvements to PlantText:</p>
						<ul>
							<li>A new File Manager button gives you the abilitity to save multiple diagrams.</li>
							<li>You must sign in with you Google account in order to use the File Manager.</li>
							<li>If you have a saved diagram, it should now appear in the File Manager as "My Saved Diagram".</li>
							<li>These diagrams are now saved to your browser's local storage, NOT on the PlantText server.</li>
							<li>Each individual diagram can now contain a larger number of characters.</li>
							<li>The Import/Export feature has been moved into the File Manager.</li>
							<li>Make sure to use the Import/Export features to save diagrams to and from your file system.</li>
						</ul>
						<p>Read more about these improvements on the Blog! And please leave us your feedback in the Forum.</p>
					</td>
				</tr>
				<tr>
					<td style="text-align:center;">
					</td>
				</tr>
				<tr>
					<td style="text-align:center;">
					</td>
				</tr>
				<tr>
					<td style="text-align:center;">
						<input name="newpopstop" id="newpopstop" type="checkbox" onclick="toggleNewspop()" >Stop showing this message.
					</td>
				</tr>
			</table>

		</div>
		<div id="file-menu-new">
			<table style="width:100%;">
				<tr>
					<td style="text-align:right;width:25%;">
						Name:
					</td>
					<td style="text-align:left;width:75%;">
						<input id="file-menu-new-name" type="text">
					</td>
				</tr>
				<tr>
					<td style="text-align:right;width:25%;">
					</td>
					<td style="text-align:left;width:75%;">
						<input id="file-menu-new-submit" class="otherbuttons" type="submit" value="New" onclick="submitFileMenuNew(); return false;">
						<input id="file-menu-new-cancel" class="otherbuttons" type="submit" value="Cancel" onclick="submitFileMenuNewCancel(); return false;">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<div class="messages" id="file-menu-new-message"></div>
					</td>
				</tr>
			</table>
		</div>
		<div id="file-menu-open">
			<table style="border:0;width=100%">
				<tr>
					<td style="vertical-align:top;text-align:right;width:25%;">
						Diagrams:
					</td>
					<td style="text-align:left;width:75%;">
						<select id="file-menu-open-list" size="10" style="width:300px"></select>
					</td>
				</tr>
				<tr>
					<td style="text-align:right;width:25%;">
					</td>
					<td style="text-align:left;">
						<input id="file-menu-open-submit" class="otherbuttons" type="submit" value="Open" onclick="submitFileMenuOpen(); return false;">
						<input id="file-menu-open-cancel" class="otherbuttons" type="submit" value="Cancel" onclick="submitFileMenuOpenCancel(); return false;">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<div class="messages" id="file-menu-open-message"></div>
					</td>
				</tr>
			</table>
		</div>
		<div id="file-menu-saveas">
			<table style="width:100%;">
				<tr>
					<td style="text-align:right;width:25%;">
						Name:
					</td>
					<td style="text-align:left;width:75%;">
						<input id="file-menu-saveas-name" type="text">
					</td>
				</tr>
				<tr>
					<td style="text-align:right;width:25%;">
					</td>
					<td style="text-align:left;width:75%;">
						<input id="file-menu-saveas-submit" class="otherbuttons" type="submit" value="Save As" onclick="submitFileMenuSaveas(); return false;">
						<input id="file-menu-saveas-cancel" class="otherbuttons" type="submit" value="Cancel" onclick="submitFileMenuSaveasCancel(); return false;">
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:left;">
						<div class="messages" id="file-menu-saveas-message"></div>
					</td>
				</tr>
			</table>
		</div>
		<textarea name="description" id="description">
		</textarea>	
		</form>
	</div>
 	<div id="footer">
		Thanks to <a href="http://www.plantuml.com">PlantUML</a>,
					<a href="http://www.graphviz.org/">Graphviz</a>,
					<a href="http://ace.c9.io/">Ace Editor</a>,
					<a href="https://github.com/johan/js-deflate">Johan Sundstr&ouml;m (js-deflate)</a>, as well as 
					<a href="http://stevenanichols.com/">Steven Nichols</a> and
					<a href="https://github.com/bafolts/">Brian Folts</a>. &copy; Copyright 2013 - 2017 <a href="http://www.arwenvaughan.com/">Arwen Vaughan</a> | <a href="http://blog.planttext.com/privacy" target="_blank">Privacy Policy</a>
	</div>
		
	<script type="text/javascript">

	  var clientId = '534457703788-oucagierq7s0v6e9529tf27njbn33g76.apps.googleusercontent.com';
	  var apiKey = 'AIzaSyBOCz7jO63UPjvRWoXlZ0TwTzBCQVsG3rQ';
	  var scopes = 'https://www.googleapis.com/auth/userinfo.email';

		function logoutGoogle() {
			window.open("https://accounts.google.com/logout",'_self',false);
		}

		// Use a button to handle authentication the first time.
		function handleClientLoad() {
			$('#loader').show();
			gapi.client.setApiKey(apiKey);
			window.setTimeout(checkAuth,1);
		}

		function checkAuth() {
			gapi.auth.authorize({client_id: clientId, scope: scopes, immediate: true}, handleAuthResult);
		}

		function handleAuthResult(authResult) {
			var authorizeButton = document.getElementById('authorize-button');
			if (authResult && !authResult.error) {
				authorizeButton.style.visibility = 'hidden';
				$('#loader').hide();
				makeApiCall();

			} else {
				authorizeButton.style.visibility = '';
				authorizeButton.onclick = handleAuthClick;
				$('#loader').hide();
			}
		}

		function handleAuthClick(event) {
			gapi.auth.authorize({client_id: clientId, scope: scopes, immediate: false}, handleAuthResult);
			return false;
		}

		// Load the API and make an API call.  Display the results on the screen.
		function makeApiCall() {
			gapi.client.load('plus', 'v1', function() {
				var request = gapi.client.plus.people.get({
					'userId': 'me'
				});
				request.execute(function(resp) {

					var html = '<div style="z-index:2000;" title="' + resp.displayName + ' (' + resp.emails[0].value + ')">';
						html += '<input id="authorize-button-logout" class="popupbuttons" type="button" onclick="logoutGoogle();" value="Logout">&nbsp;&nbsp;';
						html += '<img src="' + resp.image.url + '" alt="' + resp.displayName + ' (' + resp.emails[0].value + ')" height="30" align="top">';
						html += '</div>'; 

					var heading = document.getElementById("authorize");
					heading.innerHTML = html;

					googleResponse = resp;
					plantUserId = googleResponse.id;

					afterAuthentication();

				});
			});
		}
	</script>

	<script src="https://apis.google.com/js/client.js?onload=handleClientLoad"></script>

	<script type="text/javascript" src="js/planttext.min.js?v=13.6"></script>
	
</body>


</html>