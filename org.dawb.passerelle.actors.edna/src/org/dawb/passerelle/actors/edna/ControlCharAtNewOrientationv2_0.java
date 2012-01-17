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
 * ControlCharForReorientationv2_0
 * 
 * @author svensson
 * @date March 25, 2011
 * @project org.edna.passerelle.actors
 **/
public class ControlCharAtNewOrientationv2_0 extends AbstractEdnaPlugin {

	private static final long serialVersionUID = -2653031224929933394L;

	private final static Logger logger = LoggerFactory.getLogger(ControlCharAtNewOrientationv2_0.class);

	public ControlCharAtNewOrientationv2_0(CompositeEntity container, String name)
			throws NameDuplicationException, IllegalActionException {
		super("EDPluginControlCharAtNewOrientationv2_0", container, name);

	}
	
	@Override
	protected String getInputTagName() {
		return "XSDataInputCharacterisationv2_0";
	}

	@Override
	protected String getSchemaLocation() {
		return "mxv2/datamodel/XSDataMXv2.xsd";
	}

	@Override
	protected String getPythonLocation() {
		return "mxv2/plugins/EDPluginControlCharAtNewOrientation-v2.0/plugins/EDPluginControlCharAtNewOrientationv2_0.py";
	}

	@Override
	protected String getExampleOutputLocation() {
		return "mxv2/plugins/EDPluginControlCharAtNewOrientation-v2.0/tests/data/ControlCharForReorientationv2_0_dataOutput_betterResolution.xml";
	}

	@Override
	public String getExtendedInfo() {
		return "MXv2 Char At New Orientation";
	}

	@Override
	public String getDefaultInputXML() {

		final StringBuilder buf = new StringBuilder();

		buf.append("<?xml version=\"1.0\" ?>\n");
		buf.append("<XSDataInputCharacterisationv2_0>\n");
		buf.append("  ${mxv1InputCharacterisation}\n");
		buf.append("  ${mxv2DataCollection}\n");
		buf.append("</XSDataInputCharacterisationv2_0>\n");
		return buf.toString();
	}

	@Override
	public Properties getDefaultOutputProperties() {
		final Properties props = new Properties();
		props.put("suggestedStrategy", "//suggestedStrategy");
		props.put("possibleOrientations", "//possibleOrientations");
		return props;
	}

}
