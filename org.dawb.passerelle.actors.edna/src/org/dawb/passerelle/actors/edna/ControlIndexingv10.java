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


import java.util.Properties;

import ptolemy.kernel.CompositeEntity;
import ptolemy.kernel.util.IllegalActionException;
import ptolemy.kernel.util.NameDuplicationException;

/**
 *   EdnaPluginTransformer, copied from delay action.
 *
 *   @author svensson
 *   @date Feb 15, 2011
 *   @project org.edna.passerelle.actors
 **/
public class ControlIndexingv10 extends AbstractEdnaPlugin {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8681186522590444596L;

	public ControlIndexingv10(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlIndexingv10", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputIndexing";
	}
	
	
	protected String getSchemaLocation() {
		return "/mxv1/datamodel/XSDataMXv1.xsd";
	}
	
	@Override
	protected String getPythonLocation() {
		return "/mxv1/plugins/EDPluginControlIndexing-v1.0/plugins/EDPluginControlIndexingv10.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "/mxv1/plugins/EDPluginControlIndexing-v1.0/tests/data/XSDataIndexingResult_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv1 Indexing";
	}

	@Override
	public String getDefaultInputXML() {
		
		final StringBuilder buf = new StringBuilder();
		
		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataIndexingInput>\n");
		buf.append("    <dataCollection>\n");
		buf.append("      ${sub_wedges}\n");
		buf.append("    </dataCollection>\n");
		buf.append("    ${experimental_condition}\n");
		buf.append("</XSDataIndexingInput>\n");
		
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("file_dir",  "");
		props.put("file_path", "");
		props.put("crystal_content", "//selectedSolution/crystal/*");
		props.put("image_paths", "//predictionResult/predictionImage/path/value/text()");
		props.put("selectedSolution_content", "//selectedSolution/*");
		props.put("experimentalConditionRefined_content", "//experimentalConditionRefined/*");
		return props;
	}


}
