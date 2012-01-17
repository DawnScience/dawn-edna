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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class ReadImageHeaderPlugin extends AbstractEdnaPlugin {

	private final static Logger logger = LoggerFactory.getLogger(ReadImageHeaderPlugin.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -5053674282429774593L;
	
	
	public ReadImageHeaderPlugin(CompositeEntity container, String name) throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlReadImageHeaderv10", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputReadImageHeader";
	}

	
	protected String getSchemaLocation() {
		return "/mxv1/datamodel/XSDataMXv1.xsd";
	}
	
	@Override
	protected String getPythonLocation() {
		return "/mxv1/plugins/EDPluginGroupReadImageHeader-v1.0/plugins/EDPluginControlReadImageHeaderv10.py";
	}
	
	@Override
	protected String getExampleOutputLocation() {
		return "/mxv1/plugins/EDPluginControlIndexing-v1.0/tests/data/XSDataIndexingInput_reference.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "Read image header";
	}

	@Override
	public String getDefaultInputXML() {
		
		final StringBuilder buf = new StringBuilder();
		buf.append("<?xml version=\"1.0\"?>\n");
		buf.append("<XSDataInputReadImageHeader>\n");
		buf.append("  <image>\n");
		buf.append("    <path><value>${file_path}</value></path>\n");
		buf.append("  </image>\n");
		buf.append("</XSDataInputReadImageHeader>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("file_dir",  "");
		props.put("file_path", "");
		props.put("sub_wedges", "//subWedge"); // returns all subWedge elements
		props.put("experimental_condition", "//subWedge/experimentalCondition[1]");
		return props;
	}

}
