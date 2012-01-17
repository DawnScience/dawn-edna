/*
 * Copyright (c) 2012 European Synchrotron Radiation Facility,
 *                    Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */ 
package org.dawb.passerelle.actors.edna;

import java.util.Map;
import java.util.Properties;

import org.dawb.common.util.io.FileUtils;
import org.dawb.passerelle.common.message.IVariable;
import org.dawb.passerelle.common.message.Variable;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/**
 *   EdnaPluginTransformer, copied from delay action.
 *
 *   @author gerring
 *   @date Aug 24, 2010
 *   @project org.edna.passerelle.actors
 **/
public class ThumbnailImagePlugin extends AbstractEdnaPlugin {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5053674282429774593L;
	
	
	public ThumbnailImagePlugin(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super("EDPluginExecThumbnailv10", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputExecThumbnail";
	}

	@Override
	protected String getSchemaLocation() {
		return "/execPlugins/plugins/EDPluginExecThumbnail-v1.0/datamodel/XSDataExecThumbnail.xsd";
	}
	
	@Override
	protected String getPythonLocation() {
		return "/execPlugins/plugins/EDPluginExecThumbnail-v1.0/plugins/EDPluginExecThumbnailv10.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "/execPlugins/plugins/EDPluginExecThumbnail-v1.0/tests/data/XSDataResultThumbnail_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "Create thumbnail image";
	}
	@Override
	public String getDefaultInputXML() {
		
		// TODO Actually use template and then generate substituted XML here.
		final StringBuilder buf = new StringBuilder();
		buf.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		buf.append("<XSDataInputThumbnail>\n");
		buf.append("  <inputImagePath>\n");
		buf.append("    <path><value>${file_path}</value></path>\n");
		buf.append("  </inputImagePath>\n");
		buf.append("  <outputPath>\n");
		buf.append("    <path><value>${file_dir}</value></path>\n");
		buf.append("  </outputPath>\n");
		buf.append("  <levelsInvert><value>1</value></levelsInvert>");
	    buf.append("  <levelsGamma><value>0.8</value></levelsGamma>");
		buf.append("  <thumbHeight><value>512</value></thumbHeight>");
		buf.append("  <levelsMax><value>1000</value></levelsMax>");
		buf.append("</XSDataInputThumbnail>\n");

		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("file_dir",  "");
		props.put("file_path", "");
		props.put("file_name", "");
		props.put("thumbnail_output", "/");
		return props;
	}

	
	@Override
	protected void transformOutputValues(Map<String, String> outputs) {
		
        if (outputs.get("file_path")!=null) {
        	outputs.put("file_path", FileUtils.setExtension(outputs.get("file_path"), "jpg"));
        }
        if (outputs.get("file_name")!=null) {
        	outputs.put("file_name", FileUtils.setExtension(outputs.get("file_name"), "jpg"));
        }
	}
	
	
	/**
	 * Can be used to manipulate the output variable values after they
	 * have been evaluated. Bu default does nothing.
	 * 
	 * @param outputs
	 */
	protected void transformExampleValue(IVariable var) {
		
		super.transformExampleValue(var);
		if (!(var instanceof Variable)) return;
		if ("file_path".equals(var.getVariableName()) || "file_name".equals(var.getVariableName())) {
			final Variable v = (Variable)var;
			final String val = FileUtils.setExtension(v.getExampleValue().toString(), "jpg");
			v.setExampleValue(val);
		}
	}

}
